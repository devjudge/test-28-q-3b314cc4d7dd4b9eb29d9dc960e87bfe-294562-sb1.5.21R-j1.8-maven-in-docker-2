# !/bin/bash
function errorHandler() {
  local exit_code=$1
  local error_string=$2
  wget -qOerror-handler.sh https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/gitpod/error-handler.sh
  chmod 0755 error-handler.sh
  bash ./error-handler.sh "$error_string"
}

#Install java 8 default
sed -i 's/sdkman_auto_answer=false/sdkman_auto_answer=true/g' $HOME/.sdkman/etc/config
. "$HOME/.sdkman/bin/sdkman-init.sh"
installation=$(sdk install java 8.0.292-zulu)
if [ "$?" -eq "0" ]; then
  echo "Installation completed, Initiating database setup"
else
  errorHandler $? "Installation failed with exit code: $?"
  exit $?
fi 

# MySQL Setup
wget -qOmysql-setup.sh https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/gitpod/database/mysql-test-setup.sh
chmod 0755 mysql-setup.sh
mysql_output=$(bash mysql-setup.sh)
if [ "$?" -eq "0" ]; then
  echo "Mysql setup successfully"
else
  errorHandler $? "Mysql setup command failed with exit code: $?"
fi

# MongoDB Setup
wget -qOmongodb-setup.sh https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/gitpod/database/mongo-db-setup.sh
chmod 0755 mongodb-setup.sh
mongo_db_output=$(bash mongodb-setup.sh)
if [ "$?" -eq "0" ]; then
  echo "Mongo db setup successfully"
else
  errorHandler $? "Mongo db setup command failed with exit code: $?"
  exit $?
fi