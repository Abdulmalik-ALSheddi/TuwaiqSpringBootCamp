package com.example.day3todolist;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("toDoList")
public class Controller {

    ArrayList<Task> tasks = new ArrayList<Task>();

    @PostMapping("addTask")
    public APIResponse addTask(@RequestBody Task task)
    {
        tasks.add(task);
        return new APIResponse("Task Added!!");
    }

    @GetMapping("/display")
    public ArrayList<Task> display()
    {
        return tasks;
    }

    @PutMapping("/update/{i}")
    public APIResponse update(@RequestBody Task task, @PathVariable int i)
    {
        tasks.set(i,task);
        return new APIResponse("Task updated!!");
    }
    @DeleteMapping("/delete/{i}")
    public APIResponse delete(@PathVariable int i)
    {
        tasks.remove(i);
        return new APIResponse("Task deleted!!");
    }

    @PutMapping("/change/{i}")
    public APIResponse change(@PathVariable int i , @RequestBody Task task)
    {
       tasks.get(i).setStatus(task.getStatus());

       return new APIResponse("Task changed!!");
    }
    @GetMapping("/search")
    public String search(@RequestBody Task task)
    {
        for(int i = 0 ; i < tasks.size() ; i++)
        {
            if(tasks.get(i).title.equals(task.getTitle()))
                return tasks.get(i).title;
        }
       return "NOT FOUND!!";
    }

}
