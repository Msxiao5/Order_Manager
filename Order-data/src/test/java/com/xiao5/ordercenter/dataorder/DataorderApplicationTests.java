package com.xiao5.ordercenter.dataorder;

import com.xiao5.ordercenter.common.utils.UUIDHelper;
import com.xiao5.ordercenter.dataorder.service.IUsersService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataorderApplicationTests {

//   @Autowired
//   StringRedisTemplate redisTemplate;

   @Autowired
   RedisTemplate<String, Object> redisTemplate;

   @Autowired
   IUsersService usersService;


    @Test
    public void contextLoads() {
        String key = "hello";
        String val = "world";
        redisTemplate.execute((RedisCallback<Void>) redisConnection -> {
            redisConnection.set(key.getBytes(),val.getBytes());
            return null;
        });

        String execute = redisTemplate.execute((RedisCallback<? extends String>) redisConnection -> new String(redisConnection.get(key.getBytes())));
        System.out.println(execute);

        String hket = "hKey";
        redisTemplate.execute((RedisCallback<Void>) con ->{
            con.hSet(hket.getBytes(),"23".getBytes(), "why".getBytes());
            return null;
        });

        Map<byte[], byte[]> map = redisTemplate.execute((RedisCallback<? extends Map<byte[], byte[]>>) con ->
            con.hGetAll(hket.getBytes())
        );

        map.forEach((bytes, bytes2) -> System.out.println("key : " + new String(bytes) + "  | value : " + new String(bytes2)));
        map.entrySet().forEach(entry -> System.out.println("key : " + new String(entry.getKey()) + "  | value : " + new String(entry.getValue())));

        System.out.println("UUID:" + UUIDHelper.getUUID());

        System.out.println(uuid(true));

        System.out.println(getLong());

    }

    public static String uuid(boolean hasPrefix) {
        String uuid = UUID.randomUUID().toString();
        if (!hasPrefix) {
            uuid = uuid.replaceAll("-", "");
        }
        return uuid;
    }

    private static SecureRandom random = new SecureRandom();

    public static long getLong() {
        return Math.abs(random.nextLong());
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(23);
        list.forEach(DataorderApplicationTests::print);
        System.out.println("---------------");
        list.forEach(System.out::println);

        final List<DataorderApplicationTests.Task> tasks = Arrays.asList(
                new DataorderApplicationTests.Task(DataorderApplicationTests.Status.OPEN, 50),
                new DataorderApplicationTests.Task(DataorderApplicationTests.Status.OPEN, 20),
                new DataorderApplicationTests.Task(DataorderApplicationTests.Status.CLOSED, 60)
        );

        IntSummaryStatistics intSummaryStatistics = tasks.stream().filter(task ->
                task.getStatus() == DataorderApplicationTests.Status.OPEN).mapToInt(DataorderApplicationTests.Task::getInteger).summaryStatistics();

        int sum = tasks.stream().filter(task -> task.getStatus() == DataorderApplicationTests.Status.OPEN)
                .mapToInt(DataorderApplicationTests.Task::getInteger).sum();
        System.out.println("求和为：" + sum);

        System.out.println(tasks.stream().mapToInt(DataorderApplicationTests.Task:: getInteger).filter(value -> value >30 ).sum());

        double totalPoints = tasks
                .stream()
                .parallel()
                .map(DataorderApplicationTests.Task::getInteger) // or map( Task::getPoints )
                .reduce( 0, Integer::sum );

        System.out.println("totalPoints: " + totalPoints);

        tasks.stream()                                        // Stream< String >
                .mapToInt( DataorderApplicationTests.Task::getInteger )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );


        System.out.println("工资：" + (10000/22)/8*36);


    }

    public static void print(Integer id){
        System.out.println("当前ID为：" + id);
    }

    public static String isstatus( Integer integer){
        System.out.println("111111111111111");
        return "ssss";
    }

    private enum Status{
        OPEN,CLOSED
    };

    @Data
    private static final class Task{
        private final DataorderApplicationTests.Status status;
        private final Integer integer;

        public Task(DataorderApplicationTests.Status status, Integer integer) {
            this.status = status;
            this.integer = integer;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "status=" + status +
                    ", integer=" + integer +
                    '}';
        }
    }
}
