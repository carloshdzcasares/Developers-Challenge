Developers-Challenge

· Estado del código

[![BCH compliance](https://bettercodehub.com/edge/badge/carloshdzcasares/Developers-Challenge?branch=develop)](https://bettercodehub.com/)

[![Build Status](https://travis-ci.org/carloshdzcasares/Developers-Challenge.svg?branch=develop)](https://travis-ci.org/carloshdzcasares/Developers-Challenge)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=com.chc.challenge%3Atwitter)

GUIA DE USO:

Pueden ver una lista de Tweets filtados por un mínimo de 1500 followers en la ip:

https://apitweet.herokuapp.com/

En esta dirección se ve la potencia del APIStreaming de Tweeter.

El Api-Rest con filtros adiccionales no dispone de Front, tendrán que probarlo por Postman.

En la raíz del proyecto existe un archivo llamado: Probar API Tweet.postman_collection.json

Se puede importar en postman.

Este proyecto ataca a herokuapp, las primeras peticiones tardarán porque la APP estará dormida.

Este proyecto está incluido en un ciclo de devops.

Tienen un archivo con las claves de Twitter para descargar el proyecto y usarlas sin necesidad de tocar nada, esto 
está así a drede no es un fallo de seguridad posteriormente las cambiaré como variables de entorno en Heroku