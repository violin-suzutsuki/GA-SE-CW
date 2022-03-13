#stage 1
FROM node:14.15.1 as build
WORKDIR /app
EXPOSE 3000
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json package-lock.json ./
RUN npm install --silent && npm install react-scripts@3.3.0 -g --silent
COPY . ./

#stage 2
RUN npm run build
FROM nginx:1.20.1
WORKDIR /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY --from=build /app/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]