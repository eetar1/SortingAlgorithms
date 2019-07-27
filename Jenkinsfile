pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build'
        sh './gradlew build'
      }
    }
    stage('Test') {
      steps {
        echo 'Test'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploy'
      }
    }
  }
}