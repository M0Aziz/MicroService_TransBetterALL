const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');

const Schema = mongoose.Schema;

// Modèle Blog
const blogSchema = new Schema({
    nom: { type: String, required: true },
    description: { type: String, required: true },
    dateCreation: { type: Date, default: Date.now }
});

const Blog = mongoose.model('Blog', blogSchema);

router.post('/blogs', (req, res, next) => {
    const blog = new Blog(req.body);
    blog.save()
        .then(result => {
            res.json({
                message: 'Blog créé avec succès',
                createdBlog: result
            });
        })
        .catch(err => {
            res.status(500).json({ error: err });
        });
});

router.get('/blogs', (req, res, next) => {
    Blog.find()
        .select('nom description dateCreation _id')
        .exec()
        .then(docs => {
            const response = {
                count: docs.length,
                blogs: docs.map(doc => {
                    return {
                        nom: doc.nom,
                        description: doc.description,
                        dateCreation: doc.dateCreation,
                        _id: doc._id
                    };
                })
            };
            res.json(response);
        })
        .catch(err => {
            res.status(500).json({ error: err });
        });
});

router.get('/blogs/:blogId', (req, res, next) => {
    const id = req.params.blogId;
    Blog.findById(id)
        .select('nom description dateCreation _id')
        .exec()
        .then(doc => {
            if (doc) {
                res.json({
                    blog: doc
                });
            } else {
                res.status(404).json({ message: 'Aucun blog trouvé pour l\'ID donné' });
            }
        })
        .catch(err => {
            res.status(500).json({ error: err });
        });
});

// Route pour mettre à jour un blog par ID (PUT)
router.put('/blogs/:blogId', (req, res, next) => {
    const id = req.params.blogId;
    Blog.updateOne({ _id: id }, { $set: req.body })
        .exec()
        .then(result => {
            res.json({
                message: 'Blog mis à jour avec succès'
            });
        })
        .catch(err => {
            res.status(500).json({ error: err });
        });
});

router.delete('/blogs/:blogId', (req, res, next) => {
    const id = req.params.blogId;
    Blog.findByIdAndDelete({ _id: id })
        .exec()
        .then(result => {
            res.json({
                message: 'Blog supprimé avec succès'
            });
        })
        .catch(err => {
            res.status(500).json({ error: err });
        });
});


module.exports = router;