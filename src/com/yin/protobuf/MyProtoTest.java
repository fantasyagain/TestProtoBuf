package com.yin.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;

/**
 * Created by yanbin.yin on 2015/11/11.
 */
public class MyProtoTest {
    //PersonProbuf.Person.Builder builder=PersonProbuf.Person.newBuilder();
   public static void main(String[] args) throws InvalidProtocolBufferException {
       PersonProbuf.Person.Builder builder = PersonProbuf.Person.newBuilder();
       builder.setEmail("kkk@qunar.com");
       builder.setId(12024);
       builder.setName("Qunar");
       builder.addPhone(PersonProbuf.Person.PhoneNum.newBuilder().setNumber("137").setType(PersonProbuf.Person.PhoneType.HOME));
       builder.addPhone(PersonProbuf.Person.PhoneNum.newBuilder().setNumber("134").setType(PersonProbuf.Person.PhoneType.WORK));

       PersonProbuf.Person per1=builder.build();
       byte[] bytes=per1.toByteArray();
       /*for(int i=0;i<bytes.length;i++){
           System.out.print(bytes[i]);
       }
       System.out.print(bytes.length);
       System.out.println("-------the end-------------");*/

       PersonProbuf.Person per2=PersonProbuf.Person.parseFrom(bytes);
       System.out.println(per2.getName());
       System.out.println(per2.getId());
       System.out.println(per2.getEmail());
       List<PersonProbuf.Person.PhoneNum> phones=per2.getPhoneList();
       for(PersonProbuf.Person.PhoneNum p:phones){
           System.out.println("phone:"+p.getNumber());
       }
   }
}
