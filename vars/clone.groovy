def call(String repoUrl, String branch="master") {

    echo "Cloning repository: ${repoUrl}"

    git branch: branch, url: repoUrl

}
