import yaml
from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/repos', methods=['GET'])
def get_repos():
  with open('repos.yaml') as repos_file:
    repos = yaml.safe_load(repos_file)
    response = jsonify(repos=repos)
    response.headers.add("Access-Control-Allow-Origin", "*")
    return response

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
