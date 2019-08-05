pipeline {
  agent any
  environment {
    CI = 'true'
  }
  stages {
    stage('Build') {
      steps {
        echo "Running Sorts:"
        sh '(cd $WORKSPACE && ./gradlew build)'
        sh 'java -jar $WORKSPACE/build/libs/SortingAlgorithm-1.0-SNAPSHOT.jar 100'
        sh 'mv $WORKSPACE/AlgorithmChart.jpeg $WORKSPACE/html'
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
