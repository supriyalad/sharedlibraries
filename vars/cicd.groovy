def newgit(repo)
{
  git "${repo}" 
}
def maven()
{
  sh 'mvn package' 
}
def deploy(ip,appname)
{
  sh "scp /home/ubuntu/.jenkins/workspace/declarative_pipeline/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war" 
}
def test(path)
{
  sh "java -jar $path/testing.jar"
}
def approval(name)
{
  input message: 'Need approval before deploying on PROD', submitter: "$name" 
}
