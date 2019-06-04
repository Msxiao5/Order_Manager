package com.xiao5.ordercenter.dataorder;

import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.entity.user.Users;
import com.xiao5.ordercenter.dataorder.controller.UsersController;
import com.xiao5.ordercenter.dataorder.service.IUsersService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
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
