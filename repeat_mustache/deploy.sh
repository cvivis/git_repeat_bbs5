## 도커 이미지 이름
#IMAGE_NAME="sb-bbs"
IMAGE_NAME=$1

## 컨테이너 이름 
CONTAINER_NAME=$IMAGE_NAME

## AWS 설정
URL=$2
USERNAME=$3
PASSWORD=$4

PORT=$5

echo "----------------------"
echo "배포를 시작하겠습니다"
echo "----------------------"
echo "파라미터 확인"
echo "image_name : $IMAGE_NAME"
echo "url : $URL"
echo "user_name : $USERNAME "
echo "password : $PASSWORD"

CONTAINER_ID=`docker ps -af ancestor=${IMAGE_NAME} --format "{{.ID}}"`
echo "----------------------"
echo "CONTAINER_ID=$CONTAINER_ID"
echo "컨테이너 stop..."
docker stop $CONTAINER_ID
docker rm $CONTAINER_ID
echo "----------------------"
echo "=> git pull..."
git pull origin master
echo "----------------------"
echo "=> docker build..."
docker build -t $CONTAINER_NAME . 
echo "----------------------"
echo "=> docker run..." 
docker run -it --name $CONTAINER_NAME -d -p $PORT:8080 -e SPRING_DATASOURCE_URL=$URL -e SPRING_DATASOURCE_PASSWORD=$PASSWORD -e SPRING_DATASOURCE_USERNAME=$USERNAME $CONTAINER_NAME
echo "finish..."
echo "----------------------"
docker ps 
