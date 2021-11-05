# CI/CD With AWS
## Start with CodePipeline  
 - Name the codepipeline and leave other settings default for now.
 - Choose source provider, select GitHub version 2.
 - There will not be a connection yet, so click Connect to GitHub to establish one 
   - Give it a name and select Connect
   - Authorize it
   - Click Install Connection
   - Now select the orginization you want to connect to
   - Make sure to keep it set to "all repositories", do not change it to only show your own. This will change it for everyone!
   - Next just click connect. Don't change the number assigned to the connection.
 - Now we are back to our codepipeline configuration. 
 - Select the repository we want to watch for source changes
 - Select the branch to watch for changes
 - Click Next
 - Select a build provider: AWS CodeBuild
 - Leave the region default
 - Select the CodeBuild project we made previously, this will integrate our CodeBuild project into the build phase of our CodePipeline
 - click next to go the deploy stage
 - choose a deploy provider: AWS Elastic Beanstalk
 - Give an application name and an environment name. 
 - Click next.
 - Review settings,a nd click create pipeline





# Attempt 2:
## CodeBuild
 - Start with CodeBuild, later we will integrate this into CodePipeline's build phase
 - Project Configuration:
   - Create a new CodeBuild and give it a project name
 - Source:
   - Go through the connection steps, even though we won't be using this connection. This will be replaced by a different connection in CodePipeline.
   - Review the video to see Kyle going through these steps. The steps will probably be different for you because this connection is already established.
   - Enter a repository URL
 - Environment:
   - Select Managed Image
   - Select OS: Amazon Linux 2
   - Select Runtime(s): Standard
   - Image: The one marked 3.0
   - Environment Type: Linux
 - Buildspec:
   - Use a buildspec file
   - Don't give it a custom name, this will mean that CodeBuild will look for a file called "buildspec.yml" in the source code root, that is the same place as the POM.xml
 - Skip Batch Configuration
 - Artifacts:
   - Type: No artifacts. We will have CodePipeline manage handing artifacts off from build to later phases
 - Logs:
   - disable CloudWatch logs - you may get charged a few cents for these

## CodePipeline
 - 