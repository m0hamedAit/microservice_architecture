namespace dotNet_Client
{
    partial class Convert
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.convet = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.amountTB = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.resultTB = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // convet
            // 
            this.convet.Location = new System.Drawing.Point(118, 120);
            this.convet.Name = "convet";
            this.convet.Size = new System.Drawing.Size(88, 25);
            this.convet.TabIndex = 0;
            this.convet.Text = "Convert";
            this.convet.UseVisualStyleBackColor = true;
            this.convet.Click += new System.EventHandler(this.button1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(28, 60);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(52, 16);
            this.label1.TabIndex = 1;
            this.label1.Text = "Amount";
            // 
            // amountTB
            // 
            this.amountTB.Location = new System.Drawing.Point(103, 54);
            this.amountTB.Name = "amountTB";
            this.amountTB.Size = new System.Drawing.Size(120, 22);
            this.amountTB.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(28, 191);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(45, 16);
            this.label2.TabIndex = 3;
            this.label2.Text = "Result";
            // 
            // resultTB
            // 
            this.resultTB.Location = new System.Drawing.Point(103, 185);
            this.resultTB.Name = "resultTB";
            this.resultTB.Size = new System.Drawing.Size(120, 22);
            this.resultTB.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(229, 57);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(18, 20);
            this.label3.TabIndex = 5;
            this.label3.Text = "€";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(229, 191);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(30, 20);
            this.label4.TabIndex = 6;
            this.label4.Text = "Dh";
            // 
            // Convert
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(285, 264);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.resultTB);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.amountTB);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.convet);
            this.Name = "Convert";
            this.Text = "Convert € to dh";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button convet;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox amountTB;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox resultTB;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
    }
}

