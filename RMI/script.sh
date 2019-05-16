cd MyServer
javac RMIDeploy.java
echo "launching server..."
java RMIDeploy &
cd ../MyClient
javac Client.java
echo "launching client..."
java Client
echo "killing server..."
kill $(ps aux | grep 'RMIDeploy' | head -n 1 | awk '{print $2}')
