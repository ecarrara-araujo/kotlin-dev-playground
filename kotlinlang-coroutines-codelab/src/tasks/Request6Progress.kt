package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import contributors.logRepos
import contributors.logUsers
import kotlinx.coroutines.coroutineScope

suspend fun loadContributorsProgress(
        service: GitHubService,
        req: RequestData,
        updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
    coroutineScope {
        val repos = service.getOrgRepos(req.org)
                .also { logRepos(req, it) }
                .bodyList()
        var allUsers = emptyList<User>()
        for ((index, repo) in repos.withIndex()) {
            val users = service.getRepoContributors(req.org, repo.name)
                    .also { logUsers(repo, it) }
                    .bodyList()
            allUsers = (allUsers + users).aggregate()
            updateResults(allUsers, index == repos.lastIndex)
        }
    }
}
