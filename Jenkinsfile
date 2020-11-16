//SCRIPTED
//DECLARATIVE
pipeline{
	agent any
	environment {
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
	stages{
		stage('Checkout'){
			steps{
				sh 'mvn --version'
				sh 'docker --version'
				echo "Build"
				echo "PATH - $PATH"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_TAG - $env.BUILD_TAG"
				echo "BUILD_URL - $env.BUILD_URL"
			}
		}
		stage('Compile'){
			steps{
				sh "mvn clean compile"
			}
		}
		stage('Test'){
			steps{
				sh "mvn test"
			}
		}
		stage('Integration Test'){
			steps{
				echo "Integration Test"
			//	sh "mvn failsafe:integration-test failsafe:verify"
			}
		}
		stage('Package'){
			steps{
				echo "Package"
				sh "mvn package -DskipTests"
			}
		}
		stage('Build Docker Image'){
			steps{
				echo "Build Docker Image"
				//"docker build -t ajisreekumar/myworks:$env.BUILD_TAG"
				script{
					dockerImage = docker.build("ecr_repo:${env.BUILD_TAG}")
				}
			}
		}
		/* stage('Push Docker Image'){
			steps{
				echo "Push Docker Image"
				script{
					docker.withRegistry('','dockerhub'){
						dockerImage.push();
						dockerImage.push('latest')
					}
				}
			}
		} */
		stage('Push to ECR'){
			steps{
				echo "Push Docker Image to AWS ECR"
				script{
					docker.withRegistry('https://570443433644.dkr.ecr.eu-west-2.amazonaws.com', 'ecr:eu-west-2:aws-ecr'){
						dockerImage.push();
						dockerImage.push('latest')
					}
				}
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