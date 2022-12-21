pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        echo 'build'
        sh 'pwd'
        sh 'ls -la'
        withGradle {
          sh 'cd ./DataService; ./gradlew build'
        }
        withGradle {
          sh 'cd ./LoginService; ./gradlew build'
        }
      }
    }
    stage("test") {
      steps {
        echo 'test'
      }
    }
    stage("allure") {
      steps {
        echo 'allure'
      }
    }
    stage("sonarqube") {
      steps {
        echo 'sonarqube'
      }
    }
    stage("deploy") {
      steps {
        echo 'deploy'
      }
    }
  }
}
