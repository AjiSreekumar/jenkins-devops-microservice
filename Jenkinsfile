/* node {
	stage('Build') {
		echo "Build"
	}
	stage('Test') {
		echo "Test"
	}
	stage('Integration Test') {
		echo "Integration Test"
	} 
}*/
//SCRIPTED
/* node {
	echo "Build"
	echo "Test"
	echo "Integration Test"

} */
//DECLARATIVE
pipeline{
	agent any
	stages{
		stage('Build'){
			steps{
				echo "Build"
			}
		}
		stage('Test'){
			steps{
				echo "Test"
			}
		}
		stage('Integration Test'){
			steps{
				echo "Integration Test"
			}
		}
	} 
	post{
		always{
			echo('Run always')
		}
		success{
			echo('Run when successful')
		}
		failure{
			echo('Run when fail')
		}
	}
}