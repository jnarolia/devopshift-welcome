pipelineJob('pipeline-ci') {
    def repo = 'https://github.com/yanivomc/devopshift-welcome.git'

    triggers { // Configure when to check for changes
        scm('H/5 * * * *')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote { url(repo) }
                    branches('elbit/jenkinsdec26')
                    userRemoteConfigs {
                        userRemoteConfig {
                            name('DSL User')
                            email('jenkins-dsl@domain.com')
                        }
                    }
                }
            }
        }
        scriptPath('students/ron/Jenkinsfile')
    }
}
