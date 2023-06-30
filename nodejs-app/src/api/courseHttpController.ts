import express from "express";
import {dataSourse} from "../db/dbConnector";


export const router =express.Router();
router.get('/',async (req,res)=>{
    const result = await dataSourse.query("select *  from course");
    res.json(result);
});

router.post('/',async (req,res)=>{

    const course = req.body as course;

    if(!course.id || !/^C\d{3}$/.test(course.id.trim())|| !course.description || !/^[A-z ]{3,}$/.test(course.description.trim()) || !course.duration.trim()){
        res.status(404).send('Invalid data input');
        return;
    }
    try {

        const result = await dataSourse.query("insert into course (id,description,duration) values (?,?,?)", [course.id, course.description, course.duration]);
        if (result.affectedRows === 1) {
            res.sendStatus(201);
            return;
        }
        res.sendStatus(400);
    }catch (err:any){
        if(err.sqlState==23000){
            res.status(400).send("Duplicate Entry")
        }else{
            res.sendStatus(500)
        }


    }
})
router.delete('/:courseId',async (req,res)=>{
    if(!req.params.courseId || !/^C\d{3}$/.test(req.params.courseId)){
        res.status(404).send("Invalid data input");
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
