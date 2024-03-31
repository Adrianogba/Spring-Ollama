By default Ollama only uses your CPU for processing, 
but if you have a Nvidia or AMD GPU and want to also use them, folow the steps on the link:
https://hub.docker.com/r/ollama/ollama

To download the model, run this on the terminal (take a couple of minutes to download):
```
curl http://localhost:11434/api/pull -d '{    
"name": "llama2"  
}'
```
Or
```
curl http://localhost:11434/api/pull -d '{    
"name": "mistral"  
}'
```