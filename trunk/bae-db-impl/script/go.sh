#!/bin/bash

#env setup
mypwd=`pwd`
echo "mypwd => $mypwd"

rm -rf dest
mkdir $mypwd/dest/xml -p
mkdir $mypwd/dest/java -p

serviceSrc=$mypwd/src/java/LAmbryService.java
mapperSrc=$mypwd/src/java/LAmbryMapper.java
beanSrcDir=$mypwd/src/java/bean

serviceDest=$mypwd/dest/java/service
mapperDest=$mypwd/dest/java/mapper
beanDest=$mypwd/dest/java/bean

sourceDir=$mypwd/../src
modelDir=$mypwd/../../bae-db-model

mkdir ${serviceDest} -p
mkdir ${mapperDest} -p
mkdir ${beanDest} -p

find ${modelDir} -name "*Mapper.java" |awk -F '/dao/' {'print $2'} > $mypwd/apiList/class.list
sed -i "s/Mapper.java//g" $mypwd/apiList/class.list

#if [ -z $1 ]
#then
#  #echo "-z $1 true";
#  packageList=(`cat ${mypwd}/apiList/package.list`);
#else
#  #echo "-z $1 false";
#  packageList=($1);
#  echo "use parameter ~$1~ in go.sh";
#fi

#process xml
echo "process xml..."
#for (( j=0; j<${#packageList[@]}; j=j+1 ))
#do
  #echo "change ${packageList[j]}"
  mkdir $mypwd/dest/xml -p
  mkdir ${sourceDir}/main/resources/org/java/luke/baedb/dao/ -p
  
  classList=( `cat $mypwd/apiList/class.list` )
  for (( i=0; i<${#classList[@]}; i=i+1 ))
  do
    echo "$i =>  ${classList[i]}"
    cp -r $mypwd/src/xml/${classList[i]}Mapper.xml $mypwd/dest/xml/${classList[i]}Mapper.xml
    #cd $mypwd/dest/xml/${packageList[j]}
    sed -i -f $mypwd/sedFile/insertRemove.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/updateRemove.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/stringReplace.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/trimReplace.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/selectReplace.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/selectReplaceFix.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    #sed -i -f $mypwd/sedFile/sumFunctionInsert.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/myResultMapInsert.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    #sed -i -f $mypwd/sedFile/customizedFunctionInsert.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    #sed -i -f $mypwd/sedFile/setNullFunctionInsert.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/flushCacheFunctionInsert.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    sed -i -f $mypwd/sedFile/myCacheInsert.sed $mypwd/dest/xml/${packageList[j]}/${classList[i]}Mapper.xml
    export tempvar=`perl convertBeanNameToTableName.pl ${classList[i]}`   
    sed -i "s/L_AMBRY/${tempvar}/g" $mypwd/dest/xml/${classList[i]}Mapper.xml
    unset tempvar
    echo "copying... ${classList[i]}Mapper.xml"
    cp $mypwd/dest/xml/${classList[i]}Mapper.xml ${sourceDir}/main/resources/org/java/luke/baedb/dao/${classList[i]}Mapper.xml
  done
  echo

  #classList=( `cat $mypwd/apiList/cache.list` ) 
  classList=( `cat $mypwd/apiList/cache.list 2>/dev/null` ) 
  for (( i=0; i<${#classList[@]}; i=i+1 ))
  do
    echo "enable cache XML $i =>  ${classList[i]}"
    #cp -r $mypwd/src/xml/${classList[i]}Mapper.xml $mypwd/dest/xml/${classList[i]}Mapper.xml
    #cd $mypwd/dest/xml
    sed -i -f $mypwd/sedFile/myCacheInsert.sed $mypwd/dest/xml/${classList[i]}Mapper.xml
    echo "enable cache XML copying... ${classList[i]}Mapper.xml"
    cp $mypwd/dest/xml/${classList[i]}Mapper.xml ${sourceDir}/main/resources/org/java/luke/baedb/dao/${classList[i]}Mapper.xml

    echo "enable cache Java $i =>  ${classList[i]}"
    mkdir ${beanDest} -p
    mkdir ${beanSrcDir} -p

    cp ${modelDir}/src/main/java/org/java/luke/baedb/model/${classList[i]}.java ${beanSrcDir}/
    cp ${modelDir}/src/main/java/org/java/luke/baedb/model/${classList[i]}.java ${beanDest}/
    #sed -i -f $mypwd/sedFile/myCacheInsert.sed ${beanDest}/${classList[i]}.java
    sed -i "s/${classList[i]}/L_AMBRY/g" ${beanDest}/${classList[i]}.java
    sed -i -f $mypwd/sedFile/beanSerializableInsert.sed ${beanDest}/${classList[i]}.java
    sed -i "s/L_AMBRY/${classList[i]}/g" ${beanDest}/${classList[i]}.java
    echo "enable cache Java copying... ${classList[i]}.java"
    cp ${beanDest}/${classList[i]}.java ${modelDir}/db-model/src/main/java/org/java/luke/baedb/model/${classList[i]}.java
  done
  echo
#done

cd $mypwd/

#process java
echo "process java..."
#for (( j=0; j<${#packageList[@]}; j=j+1 ))
#do
  classList=( `cat $mypwd/apiList/class.list` )
  for (( i=0; i<${#classList[@]}; i=i+1 ))
  do
    echo "$i =>  ${classList[i]}"
    mkdir $serviceDest -p
    mkdir ${sourceDir}/main/java/org/java/luke/baedb/service/ -p
    
    cp $serviceSrc $serviceDest/${classList[i]}Service.java
    sed -i "s/service.library/service/g" $serviceDest/${classList[i]}Service.java
    sed -i "s/dao.library/dao/g" $serviceDest/${classList[i]}Service.java
    sed -i "s/model.library/model/g" $serviceDest/${classList[i]}Service.java

    sed -i "s/LAmbry/${classList[i]}/g" $serviceDest/${classList[i]}Service.java
    
    echo "copying... ${classList[i]}Service.java"
    cp $serviceDest/${classList[i]}Service.java ${sourceDir}/main/java/org/java/luke/baedb/service/${classList[i]}Service.java

    mkdir $mapperDest -p
    mkdir ${sourceDir}/main/java/org/java/luke/baedb/dao -p

    cp $mapperSrc $mapperDest/${classList[i]}Mapper.java
    sed -i "s/dao.library/dao.${packageList[j]}/g" $mapperDest/${classList[i]}Mapper.java
    sed -i "s/model.library/model.${packageList[j]}/g" $mapperDest/${classList[i]}Mapper.java
    sed -i "s/LAmbry/${classList[i]}/g" $mapperDest/${classList[i]}Mapper.java
    
    echo "copying... ${classList[i]}Mapper.java"
    cp $mapperDest/${classList[i]}Mapper.java ${sourceDir}/main/java/org/java/luke/baedb/dao/${classList[i]}Mapper.java
  done
  echo
#done

find ${mypwd}/dest -name ".svn" |xargs rm -rf

#replace source
#echo "replace source..."
#for (( j=0; j<${#packageList[@]}; j=j+1 ))
#do
#        classList=( `cat $mypwd/apiList/class.list.${packageList[j]}` )
#        for (( i=0; i<${#classList[@]}; i=i+1 ))
#        do
#        done
#        echo
#done


