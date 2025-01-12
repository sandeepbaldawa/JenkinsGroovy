def call(Map config=[:]){
node {
  stage('SCM') {
    echo 'Gatheing data from version control'
    git branch: 'master', url: 'https://github.com/sandeepbaldawa/JenkinsGroovy.git'  
  }
  
  stage('Build') {
    try{
      echo 'Building...'
    }catch(ex){
      echo 'Something went wrong'
      echo ex.toString();
      currentBuild.result = 'FAILURE'
    }
    finally{
      //cleanup
    }
  }
  
  stage('Test') {
    echo 'Testing...'
  }

  stage('Deploy') {
    echo 'Deploying...'
  }
}
}
