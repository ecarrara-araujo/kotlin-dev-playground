package tasks

import contributors.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun loadContributorsChannels(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
    coroutineScope {
        val repos = service.getOrgRepos(req.org)
                .also { logRepos(req, it) }
                .bodyList()
        val usersListChannel = Channel<List<User>>()
        repos.forEach { repo ->
            launch {
                val users = service.getRepoContributors(req.org, repo.name)
                        .also { logUsers(repo, it) }
                        .bodyList()
                usersListChannel.send(users)
            }
        }
        var allUsers = emptyList<User>()
        repeat(repos.size) { index ->
            val users = usersListChannel.receive()
            allUsers = (allUsers + users).aggregate()
            updateResults(allUsers, index == repos.lastIndex)
        }

    }
}
