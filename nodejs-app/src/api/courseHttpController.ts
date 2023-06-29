import express from "express";
import {dataSourse} from "../db/dbConnector";
console.log("HTTPcONTROLLER")

export const router =express.Router();
router.get('/',async (req,res)=>{
    const result = await dataSourse.query("select *  from course");
    res.json(result);
});

router.post('/',async (req,res)=>{
    try {
    const course = req.body as course;
    if(!/^C\d{3}$/.test(course.id)|| !/^[A-z ]{3,}$/.test(course.description) || !course.duration){
        res.status(404).send('Invalid input');
        return;
    }
        const result = await dataSourse.query("insert into course (id,description,duration) values (?,?,?)", [course.id, course.description, course.duration]);
        if (result.affectedRows === 1) {
            res.sendStatus(201);
            return;
        }
        res.sendStatus(404);
    }catch (err:any){
        res.status(404).send("Invalid Data Entry");
    }
})
router.delete('/:courseId',async (req,res)=>{
    if(!/^C\d{3}$/.test(req.params.courseId)){
        console.log("123")
        res.sendStatus(404).send("Invalid data input");
        return;
    }
    const result = await dataSourse.query("delete from course where id=?",[req.params.courseId]);
    if(result.affectedRows===1){
        res.sendStatus(204);
        return;
    }
    res.sendStatus(400);
})


type course={
    id:string,
    description:string,
    duration:string,
}
