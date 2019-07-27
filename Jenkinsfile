pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build'
        sh './gradlew build'
        sh '''pwd
ls
scp AlgorithmChart.jpeg /var/nginx '''
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