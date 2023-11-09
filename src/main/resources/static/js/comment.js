function toggleEdit(commentIndex) {
    const commentText = document.getElementById(`commentText${commentIndex}`);
    const commentEditInput = document.getElementById(`commentEditInput${commentIndex}`);
    const btnEdit = document.getElementById(`btn-comment-edit${commentIndex}`);
    const btnSave = document.getElementById(`btn-comment-save${commentIndex}`);

    // Toggle visibility of elements
    if (commentText.style.display === 'block') {
        commentText.style.display = 'none';
        commentEditInput.style.display = 'block';
        btnEdit.style.display = 'none';
        btnSave.style.display = 'block';

        // Set the input field value to the current comment text
        commentEditInput.value = commentText.textContent;
    } else {
        // If the input field is already visible, toggle it back
        commentText.style.display = 'block';
        commentEditInput.style.display = 'none';
        btnEdit.style.display = 'block';
        btnSave.style.display = 'none';
    }
}

function saveComment(commentIndex) {
    const commentEditInput = document.getElementById(`commentEditInput${commentIndex}`);
    const commentText = document.getElementById(`commentText${commentIndex}`);

    // Get the edited comment content
    const editedContent = commentEditInput.value;

    // Send the edited content to the server via an AJAX request (similar to your commentEdit function)
    // ...

    // Update the comment text with the edited content
    commentText.textContent = editedContent;

    // Toggle back to view mode
    toggleEdit(commentIndex);
}
