def call() {

    echo "Running unit tests..."

    sh """
        npm install
        npm test || true
    """
}
