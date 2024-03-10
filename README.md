If you have an Nvidia graphics card, use it for processing:
https://hub.docker.com/r/ollama/ollama

To download the model, run this on the terminal (take a couple of minutes to download):
```
curl http://localhost:11434/api/pull -d '{    
"name": "llama2"  
}'
```
