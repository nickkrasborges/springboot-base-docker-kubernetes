![diagrama kubernetes](https://github.com/nickkrasborges/springboot-base-docker-kubernetes/blob/master/diagrama_kubernetes.png)
## ETRUTURA DE DADOS 
    base de dados: mongodb
    nome do banco: meubanco
    tabela: veiculos
    script database:
        -> via linha de comando entrar no diretório do mongo e escutar o seguinte comando:
            mongorestore --drop --db your_database_name C://caminhoOndeEstaOscriptDoBanco/yourPath/
    
## Dockerfile

* Criar o arquivo Dockerfile (colocar dentro do arquivo os dados abaixo), criar o arquivo Dockerfile dentro da raiz do projeto, Obs: o nome do arquivo pode ser outro porem deve ter a extesão, por exemplo (node.dockerfile).
```
#imagem base
FROM node

#nome do criador da imagem
MAINTAINER Nick Kras Borges

#variáveis de ambiente
ENV NODE_ENV=producao
ENV PORT=3000

#copia o código fonte para dentro da imagem(. copia tudo que ta dentro da pasta pra dentro do /var/www)
COPY . /var/www

#diretrório raiz do container(RUN e ENTRYPOINT são executados dentro deste diretório)
WORKDIR /var/www

#comando executado durante o build da imagem
RUN npm install

#comando executado após o start do container
ENTRYPOINT npm start

#expões o container na porta definida 
EXPOSE $PORT
```
## Docker compose
* **docker-compose.yml** responsável por conter as informações para construir a imagem, com base no **dockerfile**
<br/>

## DOCKER - KUBERNETES - Google Cloud

* **docker**

        1) gradle clean build
        2) buildar a imagens:       docker-compose build
        3) logar no docker hub:     docker login
        4) tag para commit:         docker tag number_image_id nickkborges/springboot-docker-kubernetes:v1
        5) push no docker hub:      docker push nickkborges/springboot-docker-kubernetes

* **kubernetes**

        LOCAL:
            1) criar o deployment:      sudo kubectl create -f api-deployment.yaml
            2) criar o servico:         sudo kubectl create -f servico-deployment.yaml
            3) obter a url:             sudo minikube service service-api-springboot-docker-kubernetes --url
        
        GCLOUD:
            1) crair o cluster:     http://cloud.google.com
            2) login no gcloud:     gcloud auth login
            3) conectar no cluster: gcloud container clusters get-credentials springboot-base-docker-kubernetes --zone southamerica-east1-a --project springboot-docker-kubernetes
            4) criar o deployment:  kubectl create -f api-deployment.yaml
            5) criar o servico:     kubectl create -f servico-deployment.yaml
            6) obeter o IP externo: kubectl get services
            7) acessar api:         http://35.198.8.64:8080/api/teste
            

