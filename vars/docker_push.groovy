def call(Map config) {

    def imageName = config.imageName
    def imageTag = config.imageTag
    def credentials = config.credentials

    withCredentials([usernamePassword(
        credentialsId: credentials,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            
            docker push ${imageName}:${imageTag}
            docker push ${imageName}:latest
            
            docker logout
        """
    }

    echo "Docker image pushed: ${imageName}:${imageTag}"
}
