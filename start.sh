mvn package -B

pid0=$(netstat -anp | grep -w 8080 | sed -r 's#.* (.*)/.*#\1#' | head -n 1)
echo "killing pid: $pid0"
kill $pid0
file_count=$(ls | grep nohup_file -c)
echo "start jar server: file: nohup_file_$file_count.txt"
nohup java -jar target/quantum-0.0.1-SNAPSHOT.jar > nohup_file_$file_count.txt &
echo "DONE!"
