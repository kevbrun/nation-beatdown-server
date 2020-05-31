FROM nginx:alpine
RUN mkdir -p /usr/share/nginx/html/game
RUN mkdir -p /opt/nginx/cache
COPY ./html/index.html /usr/share/nginx/html/game
COPY ./conf/nginx.conf /etc/nginx/nginx.conf
COPY ./conf/mime.types /etc/nginx/mime.types


