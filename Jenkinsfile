pipeline {
  agent any
  environment {
    CI = 'true'
  }
  stages {
    stage('Build') {
      steps {
        echo "Running Sorts:"
        sh './$WORKSPACE/gradlew build'
        sh 'java -jar SortingAlgorithm-1.0-SNAPSHOT.jar 100'
        sh 'mv $WORKSPACE/build/libs/AlgorithmChart.jpeg $WORKSPACE/html'
      }
    }
    stage('Test') {
      steps {
        echo 'Test'
      }
    }
    stage('Master-Deploy') {
      when {
        expression { env.BRANCH_NAME == 'master' }
      }

      steps {
        sh 'sshpass -p $ETHANSCORNERPASSWORD scp -r -oStrictHostKeyChecking=no $WORKSPACE/html/ ethanscorner@$SERVER:$ETHANSCORNERLOCATION'
      }
    }
  }
}
