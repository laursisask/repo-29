FROM codeany/ib-rte-base
LABEL key="Infobip"

# Custom Plugins
USER theia
COPY plugins/GabrielBB.vscode-lombok-1.0.1.vsix /home/theia/plugins/GabrielBB.vscode-lombok-1.0.1.vsix

# Project Settings
COPY settings/project-settings.json /home/project/.theia/settings.json

# Developer tools
USER root

# Java
RUN apt-get update && apt-get -y install openjdk-11-jdk maven gradle

# Java :: restart java lang server & exclude files message dialog workaround
COPY settings/theia-settings.json /root/.theia/settings.json

# Show Initial File
ENV INIT_FILE_OPEN=/home/project/src/main/java/com/infobip/api/code/examples/SendSms.java

# Code example
COPY src /home/project/src
COPY pom.xml /home/project
