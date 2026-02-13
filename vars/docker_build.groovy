def call(Map config) {

    def imageName = config.imageName
    def imageTag = config.imageTag
    def dockerfile = config.dockerfile
    def context = config.context

    echo "Building Docker image: ${imageName}:${imageTag}"

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
