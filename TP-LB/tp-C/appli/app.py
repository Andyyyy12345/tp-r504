from flask import Flask
import os

app = Flask(__name__)

@app.route('/')
def hello_world():
    return os.environ.get('HOSTNAME')

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
