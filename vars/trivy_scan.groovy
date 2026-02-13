def call() {

    echo "Running Trivy scan..."

    sh """
        trivy image ${DOCKER_IMAGE_NAME}:${BUILD_NUMBER} || true
    """
}
