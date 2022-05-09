FROM node:alpine

WORKDIR /app
COPY package.json package-lock.json ./src/config.json ./dist/ ./
RUN npm install
EXPOSE 9105
USER node
CMD ["npm", "run", "start-docker"]
