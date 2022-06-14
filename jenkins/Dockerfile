FROM jenkins/jenkins:jdk11

#need root user
USER root

# Install tools and software
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.asc] https://download.docker.com/linux/debian $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y software-properties-common unzip wget maven docker-ce-cli

# Install Terraform
ARG TERRAFORM_VERSION=1.2.2
RUN wget --progress=dot:mega https://releases.hashicorp.com/terraform/${TERRAFORM_VERSION}/terraform_${TERRAFORM_VERSION}_linux_amd64.zip

RUN \
        unzip terraform_${TERRAFORM_VERSION}_linux_amd64.zip && \
        mv terraform /usr/local/bin/ && \
        chmod +x /usr/local/bin/terraform && \
        terraform --version

#jenkins user
USER jenkins

RUN jenkins-plugin-cli --plugins "blueocean:1.25.3 docker-workflow:1.28"