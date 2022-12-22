pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        echo 'build'
        sh 'cd ./DataService; ./gradlew build'
        sh 'cd ./LoginService; ./gradlew build'
      }
    }
    stage("test") {
      steps {
        sh 'cd ./DataService; ./gradlew clean test --info'
        sh 'cd ./LoginService; ./gradlew clean test --info'
      }
    }
    stage("allure") {
      steps {
        sh 'cd ./DataService; ./gradlew allureServe'
        sh 'cd ./LoginService; ./gradlew allureServe'
      }
    }
    stage("sonarqube") {
      steps {
        sh 'cd ./DataService; ./gradlew sonarqube'
        sh 'cd ./LoginService; ./gradlew sonarqube'
      }
    }
    stage("deploy") {
      steps {
        echo 'deploy'
      }
    }
  }
}
