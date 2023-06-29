import express from "express";
import {dataSourse} from "../db/dbConnector";

export const router =express.Router();
router.get('/',async (req,res)=>{
    const result = await dataSourse.query("select *  from course");
    res.json(result);
});

router.post('/',async (req,res)=>{
    const course = req.body as course;
    const result = await dataSourse.query("insert into course (id,description,duration) values (?,?,?)",[course.id,course.description,course.duration]);
    res.sendStatus(201);
})
router.delete('/:courseId',async (req,res)=>{
    const result = await dataSourse.query("delete from course where id=?",[req.params.courseId]);
    res.sendStatus(204);
})


type course={
    id:string,
    description:string,
    duration:string,
}
