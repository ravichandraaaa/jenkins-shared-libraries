def call(Map config) {

    def imageName = config.imageName
    def imageTag = config.imageTag
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def context = config.context ?: '.'

    echo "Building Docker image: ${imageName}:${imageTag} using ${dockerfile}"

    timeout(time: 30, unit: 'MINUTES') {
        sh """
            export DOCKER_BUILDKIT=1
            
            docker build \
            --progress=plain \
            -t ${imageName}:${imageTag} \
            -t ${imageName}:latest \
            -f ${dockerfile} \
            ${context}
        """
    }

    echo "Docker image built successfully: ${imageName}:${imageTag}"
}
