/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int maxDepth(struct TreeNode* root) {
    if(root==NULL)  return 0;
    if(root->left==NULL && root->right==NULL){
        return 1;
    }
    else if(root->left==NULL){
        return 1 + maxDepth(root->right);
    }
    else if(root->right==NULL){
        return 1 + maxDepth(root->left);
    }
    else{
        int l1=maxDepth(root->left);
        int l2=maxDepth(root->right);
        if(l1>l2)
            return 1 + l1;
        else
            return 1 + l2;    
    }
}
