FROM codeany/rte-base
LABEL key="Infobip"
USER root

# Java
# RUN apt-get update && apt-get -y install openjdk-11-jdk maven gradle

# Editor extensions
# RUN code --install-extension gabrielbb.vscode-lombok

# Code example
RUN git clone https://github.com/infobip/send-sms-java-example.git /home/project
