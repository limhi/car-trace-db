#!/bin/bash -e
mypwd=`pwd`
alias cp='cp -f'
#packageList=(ac ads charge forall leaveagent library login)
#if [ -z $1 ]
#then
#  #echo "-z $1 true";
#  packageList=(`cat ${mypwd}/db-core/db-core.impl/script/apiList/package.list`);
#else
#  #echo "-z $1 false";
#  packageList=($1);
#  echo "use parameter ~$1~ for update";
#fi
#echo $#;
#echo ${#packageList[@]};
#echo ${packageList[0]};
#echo ${packageList[1]};
#exit

echo "Start"
#for (( j=0; j<${#packageList[@]}; j=j+1 ))
#do
#  echo "generate ${packageList[j]} API !"
#  for (( i=5; i>=5; i=i-1 ))
#  do
#    echo "begin after ${i} sec..."
#    sleep 1
#  done
#  cd ${mypwd}/db-model/db-model.${packageList[j]}/
  cd ${mypwd}/bae-db-model/
  #mvn -e -B -U clean mybatis-generator:generate install deploy
  mvn -T 4C -e -B -U clean mybatis-generator:generate install  
  if [ "$?" -ne 0 ]; then echo "generate bae-db-model API failed"; exit 1; fi

  #mkdir -p ${mypwd}/db-core/db-core.impl/script/src/xml/${packageList[j]}/
  mkdir -p ${mypwd}/bae-db-impl/script/src/xml/
  cp ${mypwd}/bae-db-model/target/classes/org/java/luke/baedb/dao/*.xml ${mypwd}/bae-db-impl/script/src/xml/
#done

echo "===========generate DB Table Bean for API done!!!============\n\n"
echo "===========ready to process bae-db-impl for DB API...============\n\n"
#sleep 10

cd ${mypwd}/bae-db-impl/script

#if [ -z $1 ]
#then
  bash go.sh;
#else
#  bash go.sh $1;
#fi


if [ "$?" -ne 0 ]; then echo "translate Java/XML in bae-db-impl failed"; exit 1; fi

#generate all table list
cd ${mypwd}
grep -r "tableName=" bae-db-impl/  |grep -v .svn|awk -F "\"" '{print $4}'|sort -u > allTableList &

cd ${mypwd}/bae-db-impl
#mvn -e -B -U clean install deploy
mvn -T 4C -e -B -o clean install
if [ "$?" -ne 0 ]; then echo "maven build bae-db-impl failed"; exit 1; fi

echo "Done"
