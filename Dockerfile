FROM node:lts-alpine

WORKDIR /app
COPY package*.json ./
RUN npm install -g @quasar/cli
COPY . .

RUN yarn
RUN quasar build

EXPOSE 8080
CMD ["quasar", "dev"]

