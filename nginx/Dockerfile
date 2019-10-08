FROM nginx:alpine
RUN mkdir -p /usr/share/nginx/html/game
#RUN mkdir -p /usr/share/nginx/html/downloads/windows
#RUN mkdir -p /usr/share/nginx/html/downloads/android
COPY ./html/index.html /usr/share/nginx/html/game
COPY ./conf/nginx.conf /etc/nginx/nginx.conf



