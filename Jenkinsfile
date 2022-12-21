pipeline {
  agent any
  tools {
    gradle 'Gradle-7.6'
  }
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
