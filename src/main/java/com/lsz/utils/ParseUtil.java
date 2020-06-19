package com.lsz.utils;

import com.lsz.Enum.MyEnum;
import com.lsz.annotation.MyAnnotation;
import com.lsz.pojo.MTT;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

public class ParseUtil<T> {

    private Class<T> tClazz;
    private Class<Validate> vClazz = Validate.class;

    public ParseUtil(T t) {
        tClazz = (Class<T>)t.getClass();
    }

    /**
     * 解析文件，利用反射实现
     * @param file
     */
    public void parseTxt(File file) {
        try(
                final FileInputStream fileInputStream = new FileInputStream(file);
                final InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName(MyEnum.UTF8.getValue()));
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            System.out.println("开始解析文件");
            String line = bufferedReader.readLine();
            //获取所有的字段名
            System.out.println("开始获取所有的字段名");
            String[] fields = null;
            if (line != null) {
                fields = line.split(MyEnum.SPLIT.getValue());
            }
            //对行数据进行处理
            System.out.println("开始对数据进行处理");
            List<String> parseData = new LinkedList<>();
            while ((line = bufferedReader.readLine()) != null) {
                boolean append = true;
                //按｜分割字符串
                final String[] values = line.split(MyEnum.SPLIT.getValue());
                //判断values的个数和fields的个数是否一样
                if (values.length != fields.length) {
                    continue;
                }
                //遍历每个字段对应的值
                int index = 0;
                for (String field : fields) {
                    //反射获取范型T中的字段
                    try {
                        final Field declaredField = tClazz.getDeclaredField(field);

                        //由于是private，设置权限为true
                        declaredField.setAccessible(true);
                        //获取字段上的自定义的注解
                        final MyAnnotation declaredAnnotation = declaredField.getDeclaredAnnotation(MyAnnotation.class);
                        //若有注解
                        if (declaredAnnotation != null) {
                            //获取注解的值
                            final String value = declaredAnnotation.value();
                            //根据这个值获取对应的校验方法
                            final Method method = vClazz.getDeclaredMethod(value, String.class);
                            //调用校验方法，为static，返回类型为布尔值
                            boolean flag = (boolean)method.invoke(null, values[index]);
                            if (!flag) {
                                append = false;
                                break;
                            }
                        }
                        index++;
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("反射获取字段或注解出现错误。。。");
                    }
                }

                if (append) {
                    parseData.add(line);
                }

            }

            //将数据写入到文件中
            if (parseData.size() > 0) {
                System.out.println("开始写入数据");
                //获取名字或后缀
                final String fileName = file.getName();
                final int i = fileName.lastIndexOf(MyEnum.PERIOD.getValue());
                String nameWithoutSuffix = fileName.substring(0, i);
                String suffix = fileName.substring(i + 1);

                //获取目标文件
                final File targetFile = new File(nameWithoutSuffix + MyEnum.PARSE.getValue() + MyEnum.PERIOD.getValue() + suffix);
                //判断是否为文件并且是否存在
                if (targetFile.isFile() && targetFile.exists()) {
                    targetFile.delete();
                }

                writeData(targetFile, parseData);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将数据写入到文件中
     * @param file
     * @param parseData
     */
    private void writeData(File file, List<String> parseData) {
        try (
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName(MyEnum.UTF8.getValue()));
                final PrintWriter printWriter = new PrintWriter(outputStreamWriter);
        ) {
            for (String parseDatum : parseData) {
                printWriter.println(parseDatum);
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







    public static void main(String[] args) {
        /*final ParseUtil<MTT> mttParseUtil = new ParseUtil<>(new MTT());
        System.out.println(mttParseUtil.tClazz);*/

        /*String name = "test.sd.txt";
        final int i = name.lastIndexOf(".");
        final String substring = name.substring(0, i);
        System.out.println("substring = " + substring);
        final String substring1 = name.substring(i + 1);
        System.out.println("substring1 = " + substring1);*/

        String str = "1||3|4";
        final String[] split = str.split(MyEnum.SPLIT.getValue());
        System.out.println(split.length);
        for (String s : split) {
            System.out.println("s = " + s.equals(""));
        }


    }


    public void test() {
        System.out.println(tClazz);
    }



}
