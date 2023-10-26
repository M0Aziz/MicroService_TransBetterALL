const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const blogSchema = new Schema({
    nom: { type: String, required: true },
    description: { type: String, required: true },
    dateCreation: { type: Date, default: Date.now }
});

const Blog = mongoose.model('Blog', blogSchema);

module.exports = Blog;
